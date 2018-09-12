package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class RgstDtlsGrpComponent(noRegistDtlsField:Option[NoRegistDtlsField]=None,
                                registDtlsGroups: Option[List[RegistDtlsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noRegistDtlsField.map(_.value).getOrElse(0) != registDtlsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoRegistDtlsField.TagId,noRegistDtlsField.map(_.value).getOrElse(0), registDtlsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noRegistDtlsField.foreach(fmt(b,_))
    registDtlsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object RgstDtlsGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    RegistDtlsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoRegistDtlsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    RegistDtlsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    RegistDtlsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoRegistDtlsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = RegistDtlsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[RgstDtlsGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(RgstDtlsGrpComponent(myFields.get(NoRegistDtlsField.TagId).flatMap(f=>NoRegistDtlsField.decode(f)),
        if (nextTagPosLookup.contains(NoRegistDtlsField.TagId)) RegistDtlsGroup.decode(flds, nextTagPosLookup(NoRegistDtlsField.TagId)) else None))
    } else None
  }

    
}
     