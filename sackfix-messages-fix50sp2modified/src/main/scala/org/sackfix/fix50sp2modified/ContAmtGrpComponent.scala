package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class ContAmtGrpComponent(noContAmtsField:Option[NoContAmtsField]=None,
                               contAmtsGroups: Option[List[ContAmtsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noContAmtsField.map(_.value).getOrElse(0) != contAmtsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoContAmtsField.TagId,noContAmtsField.map(_.value).getOrElse(0), contAmtsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noContAmtsField.foreach(fmt(b,_))
    contAmtsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object ContAmtGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    ContAmtsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoContAmtsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    ContAmtsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    ContAmtsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoContAmtsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = ContAmtsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[ContAmtGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(ContAmtGrpComponent(myFields.get(NoContAmtsField.TagId).flatMap(f=>NoContAmtsField.decode(f)),
        if (nextTagPosLookup.contains(NoContAmtsField.TagId)) ContAmtsGroup.decode(flds, nextTagPosLookup(NoContAmtsField.TagId)) else None))
    } else None
  }

    
}
     