package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class MDRjctGrpComponent(noAltMDSourceField:Option[NoAltMDSourceField]=None,
                              altMDSourceGroups: Option[List[AltMDSourceGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noAltMDSourceField.map(_.value).getOrElse(0) != altMDSourceGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoAltMDSourceField.TagId,noAltMDSourceField.map(_.value).getOrElse(0), altMDSourceGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noAltMDSourceField.foreach(fmt(b,_))
    altMDSourceGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object MDRjctGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    AltMDSourceGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoAltMDSourceField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    AltMDSourceGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    AltMDSourceGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoAltMDSourceField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = AltMDSourceGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[MDRjctGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(MDRjctGrpComponent(myFields.get(NoAltMDSourceField.TagId).flatMap(f=>NoAltMDSourceField.decode(f)),
        if (nextTagPosLookup.contains(NoAltMDSourceField.TagId)) AltMDSourceGroup.decode(flds, nextTagPosLookup(NoAltMDSourceField.TagId)) else None))
    } else None
  }

    
}
     