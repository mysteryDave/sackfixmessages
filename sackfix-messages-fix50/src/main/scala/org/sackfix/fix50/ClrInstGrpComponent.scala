package org.sackfix.fix50

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50.xml
  */
case class ClrInstGrpComponent(noClearingInstructionsField:Option[NoClearingInstructionsField]=None,
                               clearingInstructionsGroups: Option[List[ClearingInstructionsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noClearingInstructionsField.map(_.value).getOrElse(0) != clearingInstructionsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoClearingInstructionsField.TagId,noClearingInstructionsField.map(_.value).getOrElse(0), clearingInstructionsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noClearingInstructionsField.foreach(fmt(b,_))
    clearingInstructionsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object ClrInstGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    ClearingInstructionsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoClearingInstructionsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    ClearingInstructionsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    ClearingInstructionsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoClearingInstructionsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = ClearingInstructionsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[ClrInstGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(ClrInstGrpComponent(myFields.get(NoClearingInstructionsField.TagId).flatMap(f=>NoClearingInstructionsField.decode(f)),
        if (nextTagPosLookup.contains(NoClearingInstructionsField.TagId)) ClearingInstructionsGroup.decode(flds, nextTagPosLookup(NoClearingInstructionsField.TagId)) else None))
    } else None
  }

    
}
     