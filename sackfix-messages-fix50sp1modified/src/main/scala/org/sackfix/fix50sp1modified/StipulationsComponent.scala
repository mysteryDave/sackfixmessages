package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class StipulationsComponent(noStipulationsField:Option[NoStipulationsField]=None,
                                 stipulationsGroups: Option[List[StipulationsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noStipulationsField.map(_.value).getOrElse(0) != stipulationsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoStipulationsField.TagId,noStipulationsField.map(_.value).getOrElse(0), stipulationsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noStipulationsField.foreach(fmt(b,_))
    stipulationsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object StipulationsComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    StipulationsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoStipulationsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    StipulationsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    StipulationsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoStipulationsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = StipulationsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[StipulationsComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(StipulationsComponent(myFields.get(NoStipulationsField.TagId).flatMap(f=>NoStipulationsField.decode(f)),
        if (nextTagPosLookup.contains(NoStipulationsField.TagId)) StipulationsGroup.decode(flds, nextTagPosLookup(NoStipulationsField.TagId)) else None))
    } else None
  }

    
}
     