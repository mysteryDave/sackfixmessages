package org.sackfix.fix50sp1

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.xml
  */
case class MDIncGrpComponent(noMDEntriesField:NoMDEntriesField,
                             mDEntriesGroups: List[MDEntriesGroup]) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noMDEntriesField.value != mDEntriesGroups.size)
    throw SfRepeatingGroupCountException(NoMDEntriesField.TagId,noMDEntriesField.value, mDEntriesGroups.size)

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,noMDEntriesField)
    b
  }

}
     
object MDIncGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int](
    NoMDEntriesField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    MDEntriesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int]()

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    MDEntriesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    MDEntriesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoMDEntriesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = MDEntriesGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[MDIncGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(MDIncGrpComponent(NoMDEntriesField.decode(myFields.get(NoMDEntriesField.TagId)).get,
        if (nextTagPosLookup.contains(NoMDEntriesField.TagId)) MDEntriesGroup.decode(flds, nextTagPosLookup(NoMDEntriesField.TagId)).get else List.empty))
    } else None
  }

    
}
     